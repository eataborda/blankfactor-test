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