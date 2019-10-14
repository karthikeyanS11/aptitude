package com.example.adminaptitude.ModelData;

public class ModelClassForSubCategory
{
    String subcategoryname;

    public ModelClassForSubCategory()
    {

    }
    public ModelClassForSubCategory(String subCategoryname)
    {
        this.subcategoryname=subCategoryname;
    }

    public String getSubcategoryname() {
        return subcategoryname;
    }

    public void setSubcategoryname(String subcategoryname) {
        this.subcategoryname = subcategoryname;
    }
}
