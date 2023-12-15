package com.gft.product.commands;

import com.gft.product.command.model.CreateProductCommand;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ProductCommandsTests {

    @Test
    public void GiveCreateACommand_WhenCreate_ThenReturnANewCommand(){
        //Arrange
        CreateProductCommand createProductCommand = new CreateProductCommand();
        String expectedName = "Teste";
        Double expectedValue = 9.99;

        //Act
        createProductCommand.setName("Teste");
        createProductCommand.setValue(9.99);

        //Assert
        Assert.assertEquals(expectedName, createProductCommand.getName());
        Assert.assertEquals(expectedValue, createProductCommand.getValue());
    }
}
