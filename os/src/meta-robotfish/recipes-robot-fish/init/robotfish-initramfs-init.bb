SUMMARY = "Robot Fish Initramfs Scripts"
LICENSE = "CLOSED"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI = "\
  file://init.sh \
  "

RDEPENDS_${PN} = "\
  e2fsprogs dosfstools \
  bash \
  "

S = "${WORKDIR}"

do_install() {
  install -m 0755 ${WORKDIR}/init.sh ${D}/init

  # Create device nodes expected by some kernels in initramfs
  # before even executing /init.
  install -d ${D}/dev
  mknod -m 755 ${D}/dev/console c 5 1
}

FILES_${PN}="/init /dev/*"

inherit allarch
