 
# Package Contents

- os.squashfs-xz
- boot.tar.xz
- app.squashfs-xz
- hooks
  - See below for possible files and usage
- hashes

# Lifecycle

## Install

### Package File Integrity Checks

Verifies all contents match the hashes

### hooks/before-uninstall.sh (from existing install)

Used to do cleanup while the existing install is still in place.

### hooks/before-install.sh

Executed from initramfs before default installation method.

### hooks/install.sh

Replaces default installation implementation. If it exists this script is exec'd (so it's running as PID 1), and must take responsibility for the rest of the install process. If it exits before rebooting the kernel will panic.

### Installed Package Integrity Checks

Same checks as the Package File Integrity Checks, to verify the image was successfully applied.

### hooks/after-install.sh

Executed from initramfs after installing and verifying the new image, but before rebooting. Still running in the initramfs from the old image.


## Boot

### hooks/first-boot.sh

Executed during the first boot after install. If it fails, the device will be rebooted and it will be attempted again. There is NO reboot limit, so be careful.

### Read init-command

- Read from kernel cmdline
- Read from /mnt/system-data/init-commands
