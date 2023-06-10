SUMMARY = "RaspTank software"
HOMEPAGE = "https://kickstartembedded.com"
DESCRIPTION = "Example program for Adeept RaspTank"
LICENSE = "MIT"
SRC_URI = "git://github.com/blkr35/Adeept_RaspTank;protocol=https"
SRC_URI[sha256sum] = "7bbf10f8d9eab92a77303143c98edf5a9e79347b4296d65dcec1194a1161adee"
LIC_FILES_CHKSUM = "file://LICENSE;md5=069556574df2364b5821d5c53ca4be02" 
SRCREV = "14b43058d5167350ad4e40f620ea2a0c13054877"


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
    install -d 644 ${D}${sysconfdir}/init.d
    install -d 644 ${D}${sysconfdir}/rc0.d
    install -d 644 ${D}${sysconfdir}/rc1.d
    install -d 644 ${D}${sysconfdir}/rc2.d
    install -d 644 ${D}${sysconfdir}/rc3.d
    install -d 644 ${D}${sysconfdir}/rc4.d
    install -d 644 ${D}${sysconfdir}/rc5.d
    install -d 644 ${D}${sysconfdir}/rc6.d
    install -m 0755 ${WORKDIR}/git/rasptank_service.sh ${D}${sysconfdir}/init.d/rasptank_service.sh
    ln -sf ../init.d/rasptank_service.sh ${D}${sysconfdir}/rc4.d/S20rasptank_service.sh
    ln -sf ../init.d/rasptank_service.sh ${D}${sysconfdir}/rc5.d/S20rasptank_service.sh
    ln -sf ../init.d/rasptank_service.sh ${D}${sysconfdir}/rc3.d/S20rasptank_service.sh
    ln -sf ../init.d/rasptank_service.sh ${D}${sysconfdir}/rc2.d/S20rasptank_service.sh
    ln -sf ../init.d/rasptank_service.sh ${D}${sysconfdir}/rc0.d/K20rasptank_service.sh
    ln -sf ../init.d/rasptank_service.sh ${D}${sysconfdir}/rc1.d/K20rasptank_service.sh
    ln -sf ../init.d/rasptank_service.sh ${D}${sysconfdir}/rc6.d/K20rasptank_service.sh
}

FILES_${PN} += "${sysconfdir}/init.d"

FILES_${PN} += "/home/root"
