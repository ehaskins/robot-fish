inherit core-image

SUMMARY = "Robot Fish Boot, Update and Recovery Image"
                     
IMAGE_FEATURES = "splash"
IMAGE_LINGUAS = ""
PACKAGE_INSTALL = "\
    robotfish-initramfs-init \
    ${VIRTUAL-RUNTIME_base-utils} \
    "

IMAGE_FSTYPES = " ${INITRAMFS_FSTYPES}"
