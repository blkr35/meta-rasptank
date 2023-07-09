# The is automatic generated Code by "makePipRecipes.py"
# (build by Robin Sebastian (https://github.com/robseb) (git@robseb.de) Vers.: 1.2) 

SUMMARY = "Recipe to embedded the Python PiP Package picamera"
HOMEPAGE ="https://pypi.org/project/picamera"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=a5f6282f39d52726bdc1e51d5c4b95c9"

inherit pypi setuptools3
PYPI_PACKAGE = "picamera"
SRC_URI[md5sum] = "47e815b0f21bba2a91ab3c4cd36c6f90"
SRC_URI[sha256sum] = "890815aa01e4d855a6a95dd3ad0953b872a6b954982106407df0c5a31a163e50"

# Allow cross-platform build for Bitbake
do_configure:prepend() {
sed -i '140d' ${S}/setup.py
}
