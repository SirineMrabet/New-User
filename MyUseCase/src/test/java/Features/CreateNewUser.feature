Feature: Create New User
  - name must be unique and is required for user creation
  - email must be unique and is required for user creation
  - password (not less thant 6 letters) is required
  - password and password repeat must be the same



//**************************************************** Valid Users *****************************************************
  @stable
  Scenario Outline: Create New user with valid credentials
    Given There is a no user created with the name <name> or <email>
    When I create a user with valid <name> <email> and <password>
    Then the system displays Success message of creating new user
    And the user <name> is created
    Examples:
      | name         | email            | password     |
      | Name         | User1@test.fr    | UserPass     |
      | Kullanıcıadı | User2@test.com   | Kullanıcıadı |
      | ユーザー名    | User3@test.tn    | ユーザー名   |
      | اسمالمستخدم  | User4@test.de    | اسمالمستخدم |
//***************************************************** Existing Users *************************************************
  @stable
  Scenario Outline: Create New user with a name that exists
    Given There is a user created with the name <name>
    When I create a user with the existing <name>
    Then the system displays an error msg indicating that this user exists
    And the user <name> is not created
    Examples:
      | name         |
      | aa           |

  @stable
  Scenario Outline: Create New user with an email that exists
    Given There is a user created with the email <email>
    When I create a user <name> with the existing <email>
    Then the system displays an error msg indicating that this email exists
    And the user <name> is not created
    Examples:
      | name            | email            |
      | Alex            | aa@test.com      |

//****************************************************  Wrong names **************************************************************
  @stable
  Scenario : Create New user with no name
    Given I'm in the registration Forum
    When I create a user without a name
    Then the system displays an error msg indicating that the name is Required


  @stable
  Scenario : Create New user with a blank in the name
    Given I'm in the registration Forum
    When I create a user with a blank in the name
    Then the system displays an error msg indicating that the name is Required


  //****************************************************  Wrong emails **************************************************************

  @stable
  Scenario Outline: Create New user with no email
    Given I'm in the registration Forum
    When I create a user <name> without an email
    Then the system displays an error msg indicating that the email is Required
    And the user <name> is not created
    Examples:
      | name            |
      | UserName        |

  @stable
  Scenario Outline: Create New user with wrong emails
    Given I'm in the registration Forum
    When I create a user with correct <name> and wrong <email>
    Then the system displays an error msg indicating that the email  is wrong
    And the user <name> is not created
    Examples:
      | name            | email            |
      | UserName        | User             |
      | UserName        | us@              |
      | UserName        | US@test          |
      | UserName        | us@test;tr       |
      | UserName        | @test.ln         |
      | UserName        | us@;rf           |
      | UserName        | UStest.fr        |

  //****************************************************  Wrong Passwords **************************************************************

  @stable
  Scenario Outline: Create New user with no password
    Given I'm in the registration Forum
    When I create a user <name> without password
    Then the system displays an error msg indicating that the password is missing
    And the user <name> is not created
    Examples:
      | name            |
      | UserName        |

  @stable
  Scenario Outline: Create New user with  password and repeat password different
    Given I'm in the registration Forum
    When I create a user <name> with <password> and <RepeatPass> different
    Then the system displays an error msg indicating that the password and  repeat password are different
    And the user <name> is not created
    Examples:
      | name            | password |RepeatPass |
      | UserName        | test12$  | test12    |
      | UserName        | test123  | test234   |

  @stable
  Scenario Outline: Create New user with  password length inferior to six
    Given I'm in the registration Forum
    When I create a user <name> with <password> length inferior to six
    Then the system displays an error msg indicating that the password length is inferior to six
    And the user <name> is not created
    Examples:
      | name            | password |
      | UserName        | test     |
      | UserName        | test1    |