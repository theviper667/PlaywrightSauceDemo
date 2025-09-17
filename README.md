# PlaywrightSauceDemo
Automated smoke tests for the SauceDemo site using Playwright in Java

## Prerequisites

1. Java installed and configured in `PATH`.
2. Maven installed and configured in `PATH`.

## Execute Test Suite
Run smoke test suite and generate allure report via `mvn clean test allure:serve` (This will open the report automatically after execution)

## Scenarios Tested
1. Login and logout for a valid user
2. Attempting to login as an invalid user
3. Testing of dynamic button functionality on Inventory page
4. Testing of dynamic button functionality on Product page
5. Testing of complete checkout flow (happy path)
