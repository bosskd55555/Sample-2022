$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./src/test/resources/Features/Test/Test_new.feature");
formatter.feature({
  "name": "Test",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "sample scenario",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "sample test url navigation",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginBDD.sample_test_url_navigation()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Login into the page with username and password",
  "rows": [
    {
      "cells": [
        "Username",
        "password"
      ]
    },
    {
      "cells": [
        "standard_user",
        "secret_sauce"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "LoginBDD.login_into_the_page_with_username_and_password(String\u003e\u003e)"
});
formatter.result({
  "status": "passed"
});
});