pipeline {
    agent any
    stages {
        stage('Build') {
            agent { docker 'maven:3.8.6-eclipse-temurin-11' } 
            steps {
                sh 'mvn --version'
                sh 'mvn clean install'
                sh 'mvn package'
            }
            /*steps {
                sh 'ls'
                sh 'sudo ./mvnw clean install'
                sh 'sudo ./mvnw package'
            }*/
        }
        stage('Deploy') {
            /*steps {
                sh 'mvn deploy'
            }*/	
            steps {
                ftpPublisher alwaysPublishFromMaster: false, 
                        masterNodeName: '',
                        paramPublish: [ parameterName: "" ],
                        continueOnError: false, 
                        failOnError: false, 
                        publishers: 
                        [ [
                            configName: 'download.dev.localnet (Local Download Server)', 
                            transfers: 
                            [
                                [
                                    asciiMode: false, 
                                    cleanRemote: false, 
                                    excludes: '**/*-tests.jar, **/*-javadoc.jar, **/*.lite*, **/*.common*', 
                                    flatten: true, 
                                    makeEmptyDirs: false, 
                                    noDefaultExcludes: false, 
                                    patternSeparator: '[, ]+', 
                                    remoteDirectory: '/repository/authBackend', 
                                    remoteDirectorySDF: false, 
                                    removePrefix: '', 
                                    sourceFiles: '**/target/*-SNAPSHOT.jar'
                                ] 
                        ], 
                        usePromotionTimestamp: false, 
                        useWorkspaceInPromotion: false, 
                        verbose: true
                    ] ]      
            }
        }
    }
} 