def profile = "dev"
def hub = "http://zalenium:4444/wd/hub"
def browsers = ["chrome", "firefox"]

def stepsForParallel = [:]

for (int i = 0; i < browsers.size(); i++) {
    def browser = browsers.get(i)

    def cmd = "mvn clean verify -P${profile} -Dwebdriver=${browser} -Dremote.hub=${hub} -Dbinary.directory=/tmp/driver/binaries -Ddownloaded.directory=/tmp/driver/zips"
    def stepName = "Test ${browser}"

    stepsForParallel[stepName] = mvn(stepName, cmd)
}

parallel stepsForParallel

def mvn(stepName, cmd) {
    return {
        node {
            env.PATH = "${tool 'maven-3.5'}/bin:${env.PATH}"

            stage('checkout') {
                checkout scm
            }

            stage('check java') {
                sh "java -version"
            }

            stage('check maven') {
                sh "mvn -v"
            }

            stage(stepName) {
                sh cmd
                cucumber '**/*.json'
            }
        }
    }
}