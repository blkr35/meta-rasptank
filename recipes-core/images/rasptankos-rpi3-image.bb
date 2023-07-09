# Base this image on raspbtankos-base-image.bb
require recipes-core/images/rasptankos-base-image.bb

LICENSE = "MIT"

COMPATIBLE_MACHINE = '(raspberrypi3-64)'

# Image size will be extended to fill up the sdcard
CORE_IMAGE_EXTRA_INSTALL_append = " 96boards-tools"

# Additional python modules
CORE_IMAGE_EXTRA_INSTALL_append = " pip-rpi.gpio"
CORE_IMAGE_EXTRA_INSTALL_append = " pip-adafruit.pca9685"
CORE_IMAGE_EXTRA_INSTALL_append = " pip-adafruit.gpio"
CORE_IMAGE_EXTRA_INSTALL_append = " pip-adafruit.pureio"
CORE_IMAGE_EXTRA_INSTALL_append = " pip-rpi-wsx"
CORE_IMAGE_EXTRA_INSTALL_append = " pip-mpu-raspberrypi"
CORE_IMAGE_EXTRA_INSTALL_append = " pip-pybase"
CORE_IMAGE_EXTRA_INSTALL_append = " pip-imutils"
CORE_IMAGE_EXTRA_INSTALL_append = " pip-flask-cors"
CORE_IMAGE_EXTRA_INSTALL_append = " pip-zmq"
CORE_IMAGE_EXTRA_INSTALL_append = " pip-picamera"

