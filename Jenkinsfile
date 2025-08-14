// Jenkinsfile (Windows agent)
pipeline {
  agent any

  options {
    timestamps()
    ansiColor('xterm')
  }

  // If you configured tools in "Manage Jenkins > Global Tool Configuration",
  // set their names below (e.g., Maven: "M3", JDK: "JDK17").
  tools {
    maven 'M3'
    jdk   'JDK17'
  }

  parameters {
    string(name: 'CUCUMBER_TAGS', defaultValue: '', description: 'e.g. @smoke or @smoke or @regression')
  }

  stages {
    stage('Checkout') {
      steps {
        git branch: 'main', url: 'https://github.com/YUVARAJSEKAR12/JenkinsPipeline.git'
      }
    }

    stage('Build') {
      steps {
        // Windows uses 'bat' instead of 'sh'
        bat 'mvn -B -q --version'
        bat 'mvn -B clean compile'
      }
    }

    stage('Run Cucumber Tests') {
      steps {
        script {
          // Build the tag arg only if provided
          def tagArg = params.CUCUMBER_TAGS?.trim() ? "-Dcucumber.filter.tags=\"${params.CUCUMBER_TAGS.trim()}\"" : ""
          bat "mvn -B test ${tagArg}"
        }
      }
      post {
        always {
          // Publish reports (adjust patterns to your project)
          junit '**/target/surefire-reports/*.xml'
          // If you generate cucumber.json, publish it:
          // Requires "Cucumber reports" plugin
          cucumber fileIncludePattern: '**/target/cucumber.json', trendsLimit: 10
        }
      }
    }
  }

  post {
    success { echo '✅ Build & tests passed' }
    failure { echo '❌ Build or tests failed' }
  }
}
