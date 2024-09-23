# blankfactor-test
A simple exercise of searching on the web page and subscribing to the news portal

## Use sample project locally
- Verify that you have `Git`
- Verify that you have `Java` installed, also that you already setup the following environment variables: `$PATH` and `$JAVA_HOME`
- Clone the repository and move inside that path:
```shellscript
$ git clone git@github.com:eataborda/blankfactor-test.git
$ cd ./blankfactor-test
```

### Run tests
- Run all tests on the src (Can select: chrome, firefox, edge):
```
$ ./gradlew -Ddriver="chrome"
```

### Generate report
Once you have run the tests you can generate the Allure report by running the following command:
```
$ allure generate build/allure-results --clean
```
After running the above command successfully you will be able to find the report in the following path: `your-project-path/allure-report`

### Open the report
Locally you can open the report in two ways:
- Using the command:
```
$ allure open /your-project-path/allure-report
```
The command starts a local web server and show the report directory's contents. Opens the report in your default browser.
- Opening the report file `/your-project-path/allure-report/index.html` in the browser of your choice. This shows the static contents of the report directory without starting any local web server.