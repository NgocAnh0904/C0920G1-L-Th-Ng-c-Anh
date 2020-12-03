function myFunction() {
    let name = document.getElementById("name");
    let idNumber = document.getElementById("idNumber");
    let dateOfBirth = document.getElementById("birthday");
    let email = document.getElementById("email");
    let address = document.getElementById("address");
    let typeOfCustomer = document.getElementById("customer_special");
    let discount = parseInt(document.getElementById("discount").value);
    let quantityIncluded = document.getElementById("number");
    let numberOfDaysRent = parseInt(document.getElementById("rent_day").value);
    let serviceType = document.getElementById("service_special");
    let typeOfRoom = document.getElementById("room_special");
    let pay = document.getElementById("pay");
    document.getElementById("confirm_name").innerHTML = name;
    document.getElementById("confirm_idNumber").innerHTML = idNumber;
    document.getElementById("confirm_birthday").innerHTML = dateOfBirth;
    document.getElementById("confirm_email").innerHTML = email;
    document.getElementById("confirm_address").innerHTML = address;
    document.getElementById("confirm_customer_special").innerHTML = typeOfCustomer;
    document.getElementById("confirm_discount").innerHTML = discount;
    document.getElementById("confirm_number").innerHTML = quantityIncluded;
    document.getElementById("confirm_rent_day").innerHTML = numberOfDaysRent;
    document.getElementById("confirm_service_special").innerHTML = serviceType;
    document.getElementById("confirm_room_special").innerHTML = typeOfRoom;

//Discount theo địa chỉ
    let saleAdd;
    switch (Address.value) {
        case "Đà Nẵng":
            saleAdd = 20;
            break;
        case "Huế":
            saleAdd = 10;
            break;
        case "Quảng Nam":
            saleAdd = 5;
            break;
        default:
            saleAdd = 0;
    }
//giảm giá theo số ngày
    let saleRent;
    switch ((parseInt(numberOfDaysRent.value) > 7) ? 1
        : (parseInt(numberOfDaysRent.value) >= 5 && parseInt(numberOfDaysRent.value) <= 7) ? 2
            : (parseInt(numberOfDaysRent.value) >= 2 && parseInt(numberOfDaysRent.value) <= 4) ? 3
                : 4) {
        case 1:
            saleRent = 30;
            break;
        case 2:
            saleRent = 20;
            break;
        case 3:
            saleRent = 10;
            break;
        case 4:
            saleRent = 0;
            break;
    }
//giảm giá theo loại khách hàng
    let saleCus;
    switch (typeOfCustomer.value) {
        case "Diamond":
            saleCus = 15;
            break;
        case "Platinum":
            saleCus = 10;
            break;
        case "Gold":
            saleCus = 5;
            break;
        case "Silver":
            saleCus = 2;
            break;
        case "Member":
            saleCus = 0;
            break;
    }
    let allGia;
    allGia = saleRent + saleCus + saleAdd;

//nhập thông tin người dùng
    function enter() {
        document.getElementById("create").style.display = "none";
        document.getElementById("show").style.display = "block";
        document.getElementById("titleName").textContent = "Customer Information";
        name.innerText = name.value;
        idNumber.innerText = idNumber.value;
        email.innerText = email.value;
        address.innerText = address.value;
        typeOfCustomer.innerText = typeOfCustomer.value;
        discount.innerText = discount.value;
        quantityIncluded.innerText = quantityIncluded.value;
        numberOfDaysRent.innerText = numberOfDaysRent.value;
        serviceType.innerText = serviceType.value;
        typeOfRoom.innerText = typeOfRoom.value;
        let sl = parseInt(quantityIncluded.value);
        let rentD = parseInt(typeOfRoom.value);
        let outPay;
        switch (serviceType.value) {
            case "Villa" :
                outPay = 500 * rentD * (1 - sl / 100) - allGia;
                break;
            case "House" :
                outPay = 300 * rentD * (1 - sl / 100) - allGia;
                break;
            case "Room" :
                outPay = 100 * rentD * (1 - sl / 100) - allGia;
                break;
        }
        pay.innerText = outPay;
    }

    function edit() {
        document.getElementById("create").style.display = "block";
        document.getElementById("show").style.display = "none";
        document.getElementById("titleName").textContent = "Customer Information";
    }
}