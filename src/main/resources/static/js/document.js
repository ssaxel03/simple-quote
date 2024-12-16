let items = [];
let totalPrice;

window.addEventListener("load", () => {

    let itemNames = document.querySelectorAll(".item-name");
    let itemUnits = document.querySelectorAll(".item-unit");
    let itemUnitPrices = document.querySelectorAll(".item-unit-price");
    let itemTaxRates = document.querySelectorAll(".item-tax-rate");
    let itemQuantities = document.querySelectorAll(".item-quantity");
    let itemFinalPrices = document.querySelectorAll(".item-final-price");
    totalPrice = document.querySelector(".total-price");

    console.log(itemUnitPrices)

    for (let i = 0; i < itemNames.length; i++) {
        items.push({
            name: itemNames[i],
            unit: itemUnits[i],
            unitPrice: itemUnitPrices[i],
            taxRate: itemTaxRates[i],
            quantity: itemQuantities[i],
            finalPrice: itemFinalPrices[i]
        })
    }

    

    console.log(items[0].unitPrice);

    items.forEach((item) => {
        item.unitPrice.addEventListener("input", (event) => adjustFinalPrice(item.finalPrice, item.unitPrice, item.quantity, item.taxRate));
        item.quantity.addEventListener("input", (event) => adjustFinalPrice(item.finalPrice, item.unitPrice, item.quantity, item.taxRate));
        item.taxRate.addEventListener("input", (event) => adjustFinalPrice(item.finalPrice, item.unitPrice, item.quantity, item.taxRate));
        
        adjustFinalPrice(item.finalPrice, item.unitPrice, item.quantity, item.taxRate);
        totalPrice.value = 0;
    })


    console.log(items);
})

const adjustFinalPrice = function (finalPrice, unitPrice, quantity, taxRate) {

    if(unitPrice.value === "" || quantity.value === "" || taxRate.value === "") {
        finalPrice.value = 0;
        totalPrice.value = 0;
        return;
    }

    finalPrice.value = ((unitPrice.value * quantity.value) * (1 + (taxRate.value / 100))).toFixed(2);

    let total = 0;
    items.forEach((item) => {
        total += parseFloat(item.finalPrice.value);
    })
    totalPrice.value = total.toFixed(2);

    if(fieldsToBeFilled()) {
        console.log(fieldsToBeFilled())
        totalPrice.value = 0;
    }
}

const fieldsToBeFilled = function () {

    let flag = false;

    items.forEach((item) => {

        console.log("should be true: " + (item.unitPrice.value === ""));
        console.log("should be true: " + (item.taxRate.value === ""))
        console.log("should be true: " + (item.quantity.value === ""))

        console.log("should be true: " + (item.unitPrice.value === "" || item.taxRate.value === "" || item.quantity.value === ""));

        if(item.unitPrice.value === "" || item.taxRate.value === "" || item.quantity.value === ""){
            flag = true;
        }
    })
    return flag;

}