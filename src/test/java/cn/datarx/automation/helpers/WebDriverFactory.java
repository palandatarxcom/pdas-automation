package cn.datarx.automation.helpers;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

final class WebDriverFactory {

    private static Logger logger = Logger.getLogger(WebDriverFactory.class);

    private static Map<String, String> binaries;

    private WebDriverFactory() {

    }

    static {
        binaries = new HashMap<>();

        for (BinaryType binaryType : BinaryType.values()) {

            for (String filename : binaryType.getBinaryFilenames()) {
                binaries.put(filename, binaryType.getDriverSystemProperty());
            }

        }


    }

    private static void initEnv() {

        String directory = Env.getProperty("binary.directory", "selenium_standalone");
        try {
            Path dir = Paths.get(directory);

            logger.debug("binary directory:" + dir.toAbsolutePath().toString());

            Files.walk(dir)
                    .filter(path -> Files.isRegularFile(path))
                    .forEach(path -> {
                        String filename = path.getFileName().toString();
                        if (binaries.containsKey(filename)) {
                            String binaryPath = path.toAbsolutePath().toString();
                            System.setProperty(binaries.get(filename), binaryPath);
                            logger.debug("set system property:" + binaryPath);
                        }
                    });
        } catch (IOException e) {
            logger.error(e);
        }
    }

    static WebDriver create() {

        initEnv();

        String webDriverProperty = Env.getProperty("webdriver");

        if (webDriverProperty == null || webDriverProperty.isEmpty()) {
            throw new IllegalStateException("The webdriver system property must be set");
        }

        try {
            return Drivers.valueOf(webDriverProperty.toUpperCase()).newDriver();
        } catch (IllegalArgumentException e) {
            String msg = String.format("The webdriver system property '%s' did not match any " +
                            "existing browser or the browser was not supported on your operating system. " +
                            "Valid values are %s",
                    webDriverProperty, Arrays.stream(Drivers
                            .values())
                            .map(Enum::name)
                            .map(String::toLowerCase)
                            .collect(Collectors.toList()));

            throw new IllegalStateException(msg, e);
        }
    }

    private enum Drivers {
        FIREFOX {
            @Override
            public WebDriver newDriver() {
                DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                return new FirefoxDriver(capabilities);
            }
        }, CHROME {
            @Override
            public WebDriver newDriver() {
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                return new ChromeDriver(capabilities);
            }
        }, PHANTOMJS {
            @Override
            public WebDriver newDriver() {
                DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
                return new PhantomJSDriver(capabilities);
            }
        }, IE {
            @Override
            public WebDriver newDriver() {
                DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                return new InternetExplorerDriver(capabilities);
            }
        };

        public abstract org.openqa.selenium.WebDriver newDriver();

    }
}
