Feature:
  Verify different GET operations using REST-assured

  Scenario: Verify one author of the post
    Given   I perform GET operation for "/posts"
    Then I should see the author name as "Karthik KK"

  Scenario: Verify collection of authors in the post
    Given   I perform GET operation for "/posts"
    Then I should see the author names

  Scenario: Verify Parameter of Get
    Given   I perform GET operation for "/posts"
    Then I should see verify GET Parameter

  Scenario: Verify Post operation
    Given   I perform POST operation for "/posts"

  Scenario: Verify Post operation for Profile
    Given I perform GET operation for "/posts/{profileNo}/profile" with body
      | name | profile |
      | Sams | 2       |
      Then I should see the body has name as "Sams"
