import org.example.LoginPage;
import org.example.PlaylistPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork18 extends BaseTest {

   LoginPage loginPage = null;
   PlaylistPage playlistPage = null;


   @Test(groups = "smoke")
   public void playSong() {
       String songName = "Airbit";
       String playlistName = "Popmusic";
       loginPage = new LoginPage(driver);
       loginPage.login("Yevhenii.Ustenko@testpro.io", "Fantazer120393!");
       playlistPage = new PlaylistPage(driver);
       playlistPage.doubleClickByChoosePlaylist(playlistName);
       playlistPage.getSelectSong(songName).click();
       Assert.assertTrue(playlistPage.getSoundBar().isDisplayed());
   }
}

