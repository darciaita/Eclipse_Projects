

function selectedQuery()
{
    var selectedOption = document.getElementById("queries").value;
    var labelText = document.getElementById("labelQueryID");
    switch(selectedOption)
    {
        case "cityWithID":
        {
            labelText.innerHTML="City ID : ";
            var textField = document.getElementById("elementID");
            textField.setAttribute("placeHolder","City ID");
            textField.disabled=false;
            break;
        }
        case "allCities":
        {
            labelText.innerHTML="City ID : ";
            var textField = document.getElementById("elementID");
            textField.setAttribute("placeHolder","City ID");
            textField.disabled=true;
            break;
        }
        case "countryWithCode":
        {
            labelText.innerHTML="Country code : ";
            var textField = document.getElementById("elementID");
            textField.setAttribute("placeHolder","Country Code");
            textField.disabled=false;
            break;
        }
        case "allCountries":
        {
            labelText.innerHTML="Country Code : ";
            var textField = document.getElementById("elementID");
            textField.setAttribute("placeHolder","Country Code");
            textField.disabled=true;
            break;
        }
    }
    
}
