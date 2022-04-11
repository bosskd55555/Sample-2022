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
  "name": ": sample test url navigation",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginBDD.sample_test_url_navigation()"
});
formatter.result({
  "status": "passed"
});
});