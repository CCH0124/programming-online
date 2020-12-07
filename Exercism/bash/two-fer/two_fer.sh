#!/usr/bin/env bash
main() {
    local who="you"
    # (( is an arithmetic operation while [[ is used for strings.
    if (( $# > 0 )); then
        who=$1
    fi
    echo "One for $who, one for me." 
    
}

main "$@"
