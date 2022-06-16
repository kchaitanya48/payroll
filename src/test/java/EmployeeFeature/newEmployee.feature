Feature: employee

  Scenario: Employee
    When send employee request to enroll the member
    Then new enroll member details from "newEmployee.json" should match with new enroll member from backend database
