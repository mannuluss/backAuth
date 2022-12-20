pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install'
                sh 'mvn package'
            }
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