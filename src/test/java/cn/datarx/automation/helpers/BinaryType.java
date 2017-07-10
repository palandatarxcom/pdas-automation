package cn.datarx.automation.helpers;

import java.util.ArrayList;

public enum BinaryType {
    INTERNET_EXPLORER(
            new ArrayList<String>() {{
                add("IEDriverServer.exe");
            }},
            "webdriver.ie.driver"),
    GOOGLE_CHROME(
            new ArrayList<String>() {{
                add("chromedriver.exe");
                add("chromedriver");
            }},
            "webdriver.chrome.driver"),
    PHANTOM_JS(
            new ArrayList<String>() {{
                add("phantomjs.exe");
                add("phantomjs");
            }},
            "phantomjs.binary.path"),
    OPERA_CHROMIUM(
            new ArrayList<String>() {{
                add("operadriver.exe");
                add("operadriver");
            }},
            "webdriver.opera.driver"),
    MARIONETTE(
            new ArrayList<String>() {{
                add("wires");
                add("wires.exe");
                add("geckodriver");
                add("geckodriver.exe");
            }},
            "webdriver.gecko.driver"),
    EDGE(
            new ArrayList<String>() {{
                add("MicrosoftWebDriver.exe");
            }},
            "webdriver.edge.driver");

    private final ArrayList<String> binaryFilenames;
    private final String driverSystemProperty;

    BinaryType(ArrayList<String> binaryFilenames, String driverSystemProperty) {
        this.binaryFilenames = binaryFilenames;
        this.driverSystemProperty = driverSystemProperty;
    }

    public ArrayList<String> getBinaryFilenames() {
        return binaryFilenames;
    }

    public String getDriverSystemProperty() {
        return driverSystemProperty;
    }

    public String getBinaryTypeAsString() {
        return this.toString().toLowerCase();
    }
}