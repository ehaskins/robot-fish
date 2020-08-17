SUMMARY = "Robot Fish Image with Chromium and NodeJS"
LICENSE = "MIT"

ROBOT_FISH_VERSION ?= "DEV"

IMAGE_FEATURES_append = " \
    x11-base \
    splash \
    ssh-server-dropbear \
    "

CORE_IMAGE_EXTRA_INSTALL_append = "\
    chromium-x11 \
    nodejs \
    rng-tools \
    sudo less \
    networkmanager \
    "
 
IMAGE_FSTYPES_append = " squashfs-xz"

IMAGE_BUILDINFO_VARS_prepend = "ROBOT_FISH_VERSION "

EXTRA_USERS_PARAMS = "useradd -p '' app;"

inherit core-image image-buildinfo extrausers
