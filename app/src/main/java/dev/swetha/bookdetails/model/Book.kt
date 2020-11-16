package dev.swetha.bookdetails.model

class Book {
    var id: String? = null
    var volumeInfo: VolumeInfo? = null
    var selfLink: String? = null
    var saleInfo: SaleInfo? = null
}

class VolumeInfo {
    var title: String? = null
    var subtitle: String? = null
    var authors: List<String>? = null
    var categories: List<String>? = null
    var publisher: String? = null
    var publishedDate: String? = null
    var description: String? = null
    var imageLinks:ImageLinks?=null
}

class SaleInfo {
    var country: String? = null
    var saleability: String? = null
}

class ImageLinks {

    var smallThumbnail: String? = null
    var thumbnail: String? = null
}



/*
*
* "kind": "books#volume",
"id": "vW6rXFvm4sQC",
"etag": "zv62vLE8scA",
"selfLink": "https://www.googleapis.com/books/v1/volumes/vW6rXFvm4sQC",
"volumeInfo": {
"title": "Encyclopaedia of Occupational Health and Safety: The body, health care, management and policy, tools and approaches",
"authors": [
"Jeanne Mager Stellman"
],
"publisher": "International Labour Organization",
"publishedDate": "1998",
"description": "Revised and expanded, this edition provides comprehensive coverage of occupational health and safety. A new CD-ROM version is available which provides the benefits of computer-assisted search capabilities.",
"industryIdentifiers": [
{
"type": "ISBN_10",
"identifier": "9221098141"
},
{
"type": "ISBN_13",
"identifier": "9789221098140"
}
],
"readingModes": {
"text": false,
"image": true
},
"pageCount": 1174,
"printType": "BOOK",
"categories": [
"Electronic books"
],
"averageRating": 5,
"ratingsCount": 1,
"maturityRating": "NOT_MATURE",
"allowAnonLogging": false,
"contentVersion": "0.3.4.0.preview.1",
"panelizationSummary": {
"containsEpubBubbles": false,
"containsImageBubbles": false
},
"imageLinks": {
"smallThumbnail": "http://books.google.com/books/content?id=vW6rXFvm4sQC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api",
"thumbnail": "http://books.google.com/books/content?id=vW6rXFvm4sQC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
},
"language": "en",
"previewLink": "http://books.google.co.in/books?id=vW6rXFvm4sQC&pg=SA16-PA57&dq=health&hl=&cd=2&source=gbs_api",
"infoLink": "http://books.google.co.in/books?id=vW6rXFvm4sQC&dq=health&hl=&source=gbs_api",
"canonicalVolumeLink": "https://books.google.com/books/about/Encyclopaedia_of_Occupational_Health_and.html?hl=&id=vW6rXFvm4sQC"
}
*
* */