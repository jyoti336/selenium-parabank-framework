# 🚀 Selenium Parabank Framework

A robust Selenium automation framework for [ParaBank](https://parabank.parasoft.com/parabank/index.htm) built with:
- ✅ Java + TestNG
- ✅ Page Object Model + PageFactory
- ✅ Excel-driven testing (Apache POI)
- ✅ Extent Reports with Screenshots
- ✅ Log4j2 logging
- ✅ Retry logic for failed tests
- ✅ Multi-browser & Headless mode support
- ✅ GitHub & Jenkins Integration
- ✅ CI-ready for GitHub Actions

---

## 📁 Project Structure

selenium-parabank-framework/ ├── src/test/java/ │ ├── base/ │ ├── pages/ │ ├── tests/ │ └── utils/ ├── testdata/loginData.xlsx ├── reports/ ├── screenshots/ ├── pom.xml ├── testng.xml └── README.md
---

## 🔧 Technologies Used

- Java 17
- Selenium WebDriver 4.10+
- TestNG 7.11
- Apache POI
- Extent Reports 5+
- Log4j2
- Maven
- GitHub
- Jenkins
- Chrome, Firefox, Edge (UI + Headless)

---

## 🚀 Run Tests from Terminal

```bash
# Default: Chrome (UI)
mvn clean test

# Firefox
mvn clean test -Dbrowser=firefox

# Headless Chrome
mvn clean test -Dbrowser=chrome -Dheadless=true
 Screenshot + Logs
Screenshots saved in /screenshots

Logs saved in /logs/test-log.log

HTML report in /reports/extent-report.htmlModule	Test Cases
Login	20 (+ve / -ve)
Register	✅ WIP
Transfer Funds	✅ WIP
Logout	✅ WIP👤 Author
Name: Jyotsna Pandey (@jyoti336)

Repo: selenium-parabank-framework