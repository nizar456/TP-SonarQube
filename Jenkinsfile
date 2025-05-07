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
                                credentialsId: 'b636d83f-6803-4d69-9f90-c237672741de', // Use your existing credential ID
                                branch: 'main'

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
