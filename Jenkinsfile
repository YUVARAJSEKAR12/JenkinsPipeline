pipeline {
  agent any

  tools {
    maven 'M3'   // match names from Global Tool Configuration
    jdk   'JDK17'
  }

  parameters {
    string(name: 'CUCUMBER_TAGS', defaultValue: '', description: 'e.g. @smoke or not @wip')
  }

  options {
    timestamps()
    // ansiColor('xterm') // enable only if AnsiColor plugin is installed
  }

  stages {
    stage('Checkout') {
      steps {
        git branch: 'main', url: 'https://github.com/YUVARAJSEKAR12/JenkinsPipeline.git'
      }
    }

    stage('Build') {
      steps {
        bat 'mvn -B -q --version'
        bat 'mvn -B clean compile'
      }
    }

    stage('Run Cucumber Tests') {
      steps {
        script {
          def tagArg = params.CUCUMBER_TAGS?.trim() ? "-Dcucumber.filter.tags=\"${params.CUCUMBER_TAGS.trim()}\"" : ""
          bat "mvn -B test ${tagArg}"
        }
      }
      post {
        always {
          junit '**/target/surefire-reports/*.xml'
          // If you have the Cucumber Reports plugin and create target/cucumber.json:
          // cucumber fileIncludePattern: '**/target/cucumber.json', trendsLimit: 10
        }
      }
    }
  }

  post {
    success { echo '✅ Build & tests passed' }
    failure { echo '❌ Build or tests failed' }
  }
}
