var images = ["birb.gif", "birb2.gif", "birb4.gif", "birb5.gif"],
    assetsDir = "assets/img/",
    lastImage, pageBackground

$(document).ready(() => {
    pageBackground = $(document.getElementById("page-background"))
    images = images.map(cur => $(document.createElement("img")).attr("src", assetsDir + cur).addClass("invisible")
        .addClass("birb-gif").appendTo(pageBackground))

    window.setInterval(setBackground, 10000)
    setBackground()
})

function setBackground() {
    if (lastImage) lastImage.addClass("invisible")
    lastImage = images[Math.floor(Math.random() * images.length)].removeClass("invisible")
}