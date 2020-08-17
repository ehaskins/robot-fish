# Runs from package~ to be installed while old image is still available
function beforeInstall {
}

# Install the image. Overwrite to replace default logic.
function install {
}

# Runs after image is installed and verified
function afterInstall {

}

# Runs in initramfs the first boot after installing an image
function firstBoot {

}

# Boot the image
function boot {

}
