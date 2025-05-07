pipeline {
    agent any

    tools {
        maven 'MAVEN3'          // Nom défini dans Jenkins > Global Tool Configuration
        jdk 'JDK21'             // Nom défini dans Jenkins > Global Tool Configuration
    }

    environment {
        SONAR_TOKEN = credentials('sonar-token') // Jenkins credential ID
    }

    stages {
        stage('Checkout') {
            steps {
                            git(
                                url: 'https://github.com/nizar456/TP-SonarQube.git',
                            )
                        }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean verify'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                                    bat """  // Changed from sh to bat for Windows
                                      mvn sonar:sonar ^
                                        -Dsonar.projectKey=TP-SonarQube ^
                                        -Dsonar.login=%SONAR_TOKEN%
                                    """
                                }
            }
        }
    }
}
