
pipeline {
agent any
parameters {
string(description: 'Use Cloud Environment: ', defaultValue: 'falls', name: 'UseCloudEnv')
choice(name :'cloudEnvName', choices :[

'browserstack',
'saucelab'
],
description : "Select the cloud Environment"
)
choice(name :'TestingEnvironment', choices :[
'STG',
'DEV',
'QA',
'UI'
],
description : "Select the Testing Environment"
)
choice(description : "Select the Operating System: " ,name :'Os', choices :[
'Windows',
'Mac',
'Linux',
]
)
string(description: 'Select the OS Version: ', defaultValue: 'Not defind', name: 'Os_version')
choice(name :'Headless', choices :[
'False',
'True'
],
description : "Headless Browser"
)
choice(name :'BrowserName', choices :[
'Chrome',
'Safari',
'Fire Fox',
'Internet Explorer',
'All'
],
description : "Select the Browser"
)
string(defaultValue: 'Not defind', description: 'Browser Version', name: 'BrowserVersion')
choice(name :'tag', choices :[
'@regression',
'@sanity',
'@smoke' ,
'@orderEvent',
'@loadTesting'
],
description : "Select the test suit using the corresponding Tag"
)
string(defaultValue: '2', description: 'Implicitly wait time', name: 'ImplicitlyWaitTime')
string(defaultValue: 'testkarim1980@gmail.com', description: 'email for notifications', name: 'notification_email')
}
stages {
stage('Running tests suit'){
steps{
echo "The testing Environment is : ${TestingEnvironment} "
echo "The testing Browser is : ${Browsers} "
echo "Headless Browser : ${Headless} "
echo "The running Tag is : ${tag}"
sh "mvn test -Dcucumber.filter.tags=${tag}"
// sh 'mvn test -Dcucumber.options=”–tags ${tag}”'
echo "The application testing en ${TestingEnvironment} Environment, ${Browsers} Browser and Tag ${tag} was performed"
}
}
}
post {
always {
echo "Test succeeded"
emailext attachmentsPattern: '**/*.html, **/*.pdf',
body: "${env.BUILD_URL} has result: ${currentBuild.result}",
subject: "Status of pipeline: ${currentBuild.fullDisplayName}",
to: "${notification_email}"
cucumber fileIncludePattern: 'target/reports/cucumber-reports/cucumber.json', sortingMethod: 'ALPHABETICAL'
}
}
}
