import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

baseUrl = "https://react-redux.realworld.io/"

driver = {
    WebDriverManager.chromedriver().setup()
    new ChromeDriver(new ChromeOptions())
}