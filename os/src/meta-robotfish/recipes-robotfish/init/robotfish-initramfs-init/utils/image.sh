HASH_FILE_NAME=sha256

function verifyBundle {
    bundle=$1

    pushd $bundle \
    && find . -type f \( ! -iname $HASH_FILE_NAME \) \
      | sort \
      | while read path; do 
        sha256sum $path
      done \
      | diff - $HASH_FILE_NAME \
    && popd \
}
