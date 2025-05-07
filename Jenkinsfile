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
                                credentialsId: 'your-github-credentials', // Add this line
                                branch: 'main' // Explicitly specify branch
                            )
                        }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean verify'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh '''
                      mvn sonar:sonar \
                        -Dsonar.projectKey=demo-sonar \
                        -Dsonar.login=$SONAR_TOKEN
                    '''
                }
            }
        }
    }
}
