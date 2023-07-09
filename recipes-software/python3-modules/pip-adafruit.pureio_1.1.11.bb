# The is automatic generated Code by "makePipRecipes.py"
# (build by Robin Sebastian (https://github.com/robseb) (git@robseb.de) Vers.: 1.2) 

SUMMARY = "Recipe to embedded the Python PiP Package Adafruit_PureIO"
HOMEPAGE ="https://pypi.org/project/Adafruit_PureIO"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a21fcca821a506d4c36f7bbecc0d009"

inherit pypi setuptools3
PYPI_PACKAGE = "Adafruit_PureIO"
SRC_URI[md5sum] = "f9ddf83f2166ce69522a25f82d1fcdf7"
SRC_URI[sha256sum] = "c4cfbb365731942d1f1092a116f47dfdae0aef18c5b27f1072b5824ad5ea8c7c"

do_configure:prepend() {
cat > ${S}/setup.py <<-EOF
from setuptools import setup

setup(
      name='Adafruit_PureIO',
      version='1.1.11',
      packages=['Adafruit_PureIO'],
     )
EOF
}
