#!/usr/bin/env bash

set -eEu

function on_error {
    message=$1
    echo $message

    exec /usr/bin/bash
}

trap 'on_error "Error $? at $(caller)"' ERR

mkdir -p /proc /sys /run /var/run /mnt

mount -t proc proc /proc
mount -t sysfs sysfs /sys
mount -t devtmpfs none /dev

rootfs_dir=/mnt/root
root=/dev/sda1

mkdir -p $rootfs_dir


for i in {0..10}
do
    if [ -b /dev/sda ]; then
        echo "exists"
        break
    elif [ $i -eq 10 ]; then
        on_error "Timeout waiting for $root"
    else 
        echo "Waiting for $root sleeping"
        sleep 1
    fi
done

mount /dev/sda2 $rootfs_dir

mount --move /dev $rootfs_dir/dev
mount --move /proc $rootfs_dir/proc
mount --move /sys $rootfs_dir/sys

echo "INITRAMFS WAS HERE!"

exec switch_root $rootfs_dir /sbin/init
