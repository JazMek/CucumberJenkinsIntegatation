
@regression @orderEvent @amar
Feature: FFM-OCMF-CreateOrderEventValidation
 @sanity @smoke
  Scenario Outline: Create Order Event Validation
    Given load the data with the data with "<data-file-prefix>"
    Given with data file prefixed with "<data-file-prefix>" and json file is "<json-file-prefix>"
    Then  call apis and validate with all the data provided
    Examples:
      |data-file-prefix | json-file-prefix|
      |testdata         | testdata        |