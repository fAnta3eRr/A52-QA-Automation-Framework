package org.example;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;

public class HomePage extends BasePage {

    @FindBy(css = "[id='userBadge']")
    WebElement header;

    @FindBy(xpath = "//section//i[@data-testid='sidebar-create-playlist-btn']")
    WebElement PlaylistButton;

    @FindBy(css = "[data-testid='playlist-context-menu-create-simple']")
    WebElement CreateNewPlaylist;

    @FindBy(css = "[name='name']")
    WebElement NewPlayList;

    @FindBy(xpath = "//ul/li[contains(text(),'Edit')]")
    WebElement editButtonLocator;

    @FindBy(xpath = "//ul/li//input[@type='text']")
    WebElement renamePlayListInput;
    @FindBy(css = "[data-test='view-all-songs-btn']")
    WebElement viewButton;

    @FindBy(xpath = "//li[contains(@class,'$s')]/a")
    WebElement playlistNameLocator;

    public HomePage(WebDriver existDriver) {
        super(existDriver);
    }

    public WebElement getHeader() {
        return header;
    }

    public WebElement getPlaylistButton() {
        return PlaylistButton;
    }

    public WebElement getCreateNewPlaylist() {
        return CreateNewPlaylist;
    }

    public WebElement getNewPlayList() {
        return NewPlayList;
    }

    public void clickEditButton() {
        WaitUtils.waitUntilVisibilityOfElement(pageDriver, editButtonLocator);
        editButtonLocator.click();
    }

    public WebElement getRenamePlayListInput() {
        return renamePlayListInput;
    }

    public WebElement getViewButton() {
        return viewButton;
    }

    public void creatPlayList(Actions actions, String newPlaylist) {
        actions.moveToElement(getPlaylistButton()).perform();
        getPlaylistButton().click();
        getCreateNewPlaylist().click();
        getNewPlayList().click();
        getNewPlayList().sendKeys(newPlaylist);
        getNewPlayList().sendKeys(Keys.ENTER);
    }

    public WebElement getPlaylistByName(String newPlaylist) {
        return findElement(By.xpath(String.format("//section[@id='playlists']//a[text()='%s']", newPlaylist)));
    }

   // public WebElement getPlaylistNameLocator(String playlistName) {
     //   return waitAndFindWebElement(By.xpath(String.format("//li[contains(@class,'$s')]/a", playlistName));
   // }

    public void openPlaylist(String newPlaylist) {
        getPlaylistByName(newPlaylist).click();
    }
public void renamePlaylist(String currentPlaylistName, String newPlaylistName)  {
        contextClickByElement(getPlaylistByName(currentPlaylistName));
        WebElement playlistName = waitAndFindWebElement((By) editButtonLocator);
        playlistName.click();

        WebElement renamePlaylistInput = waitAndFindWebElement((By) renamePlayListInput);
    for (int i = 0; i < currentPlaylistName.length(); i++) {
        renamePlaylistInput.sendKeys(Keys.BACK_SPACE);
    }
        renamePlaylistInput.sendKeys(newPlaylistName);
        renamePlaylistInput.sendKeys(Keys.ENTER);
        successMessageLocator.isDisplayed();

    }
}