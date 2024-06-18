package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.ComponentsPage;
import com.tutorialsninja.demo.pages.DesktopPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.LaptopAndNotebookPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(CustomListeners.class)
public class TopMenuTest extends BaseTest {
    HomePage homePage;
    DesktopPage desktopPage;
    LaptopAndNotebookPage laptopsAndNotebooksPage;
    ComponentsPage componentsPage;
    SoftAssert softAssert;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        desktopPage = new DesktopPage();
        laptopsAndNotebooksPage = new LaptopAndNotebookPage();
        componentsPage = new ComponentsPage();
        softAssert = new SoftAssert();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        homePage.mouseHoverOnDesktopsLinkAndClick();
        homePage.selectMenu("Show AllDesktops");
        String expectedText = "Desktops";
        String actualText = desktopPage.getDesktopsText();
        softAssert(actualText, expectedText, "Not navigate to Desktop page");
        softAssert.assertAll();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        homePage.mouseHoverOnLaptopsAndNotebooksLinkAndClick();
        homePage.selectMenu("Show AllLaptops & Notebooks");
        softAssert(laptopsAndNotebooksPage.getLaptopsAndNotebooksText(),
                "Laptops & Notebooks", "Not navigate to Laptops and Notebooks page");
        softAssert.assertAll();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        homePage.mouseHoverOnComponentLinkAndClick();
        homePage.selectMenu("Show AllComponents");
        softAssert(componentsPage.getComponentsText(),
                "Components", "Not navigate to Laptops and Notebooks page");
        softAssert.assertAll();
    }
}
