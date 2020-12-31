SUMMARY = "Robot Fish Image with NodeJS"
LICENSE = "MIT"

ROBOT_FISH_VERSION ?= "DEV"

IMAGE_FEATURES_append = " \
    ssh-server-dropbear \
    "

CORE_IMAGE_EXTRA_INSTALL_append = "\
    nodejs \
    rng-tools \
    sudo less \
    networkmanager \
    "
 
IMAGE_FSTYPES_append = " squashfs-xz"

EXTRA_USERS_PARAMS = "useradd -p '' app;"

inherit core-image image-buildinfo extrausers
