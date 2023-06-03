SUMMARY = "RaspTank software"
HOMEPAGE = "https://kickstartembedded.com"
DESCRIPTION = "Example program for Adeept RaspTank"
LICENSE = "MIT"
SRC_URI = "git://github.com/blkr35/Adeept_RaspTank;protocol=https"
SRC_URI[sha256sum] = "7bbf10f8d9eab92a77303143c98edf5a9e79347b4296d65dcec1194a1161adee"
LIC_FILES_CHKSUM = "file://LICENSE;md5=069556574df2364b5821d5c53ca4be02" 
SRCREV = "29b31374c6703462edc85d1bd2c4e6b894875e8a"

python do_display_banner() {
    bb.plain("***********************************************");
    bb.plain("*                                             *");
    bb.plain("*       RaspTank software Yocto recipe        *");
    bb.plain("*                                             *");
    bb.plain("***********************************************");
}

addtask display_banner before do_build

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}/home/root/
    cp -r ${WORKDIR}/git ${D}/home/root/Adeept_RaspTank
}
do_install_prepend () {
    rm -rf ${S}/.git
}


FILES_${PN} += "/home/root"
