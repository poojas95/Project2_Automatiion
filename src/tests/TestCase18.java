package tests;

import org.testng.Assert;

import pages.HomePage;
import pages.ProductsPage;

public class TestCase18 extends TestBasic {

	public void viewCategoryProducts() {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        verifyThatCategoriesAreVisibleOnLeftSideBar();
        verifyThatCategoryPageIsDisplayedAndConfirmTextWomenDressProducts();
        verifyThatUserIsNavigatedToThatCategoryPage();
    }

    @Step("Verify that categories are visible on left side bar")
    private void verifyThatCategoriesAreVisibleOnLeftSideBar() {
        boolean categoriesAreVisible = new HomePage(getDriver())
                .getCategories()
                .isDisplayed();
        Assert.assertTrue(categoriesAreVisible, "Verify that categories are visible on left side bar");
    }

    @Step("Verify that category page is displayed and confirm text 'WOMEN - DRESS PRODUCTS'")
    private void verifyThatCategoryPageIsDisplayedAndConfirmTextWomenDressProducts() {
        String titleTextCenter = new HomePage(getDriver())
                .womenCategoryClick()
                .dressCategoryClick()
                .getTitleTextCenter()
                .getText();
        Assert.assertEquals(titleTextCenter, "WOMEN - DRESS PRODUCTS", "Verify that category page is displayed and confirm text 'WOMEN - DRESS PRODUCTS'");
    }

    @Step("Verify that user is navigated to that category page")
    private void verifyThatUserIsNavigatedToThatCategoryPage() {
        String titleTextCenter = new ProductsPage(getDriver())
                .menCategoryClick()
                .tShirtsCategoryClick()
                .getTitleTextCenter()
                .getText();
        Assert.assertEquals(titleTextCenter, "MEN - TSHIRTS PRODUCTS", "Verify that user is navigated to that category page");
    }
}
