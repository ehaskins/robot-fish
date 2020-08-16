require recipes-core/psplash/psplash_git.bb

FILESEXTRAPATHS_prepend := "${THISDIR}/../../files/splash:"

SPLASH_IMAGES = " file://${SPLASH_IMAGE};outsuffix=robotfish"

SRC_URI =+ "\
  git://git.yoctoproject.org/psplash \
  file://psplash-colors.h \
  file://psplash-bar.png \
"

SRC_URI_remove = "git://git.yoctoproject.org/${BPN}"

PACKAGECONFIG_append=" no-startup-msg img-fullscreen"

PACKAGECONFIG[no-startup-msg] = "--disable-startup-msg"
PACKAGECONFIG[img-fullscreen] = "--enable-img-fullscreen"

do_configure_append () {
  cp ${WORKDIR}/psplash-colors.h ${S}
  cp ${WORKDIR}/psplash-bar.png ${S}/base-images/
}
