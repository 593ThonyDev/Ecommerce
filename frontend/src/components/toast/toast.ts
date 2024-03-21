import { useState, useEffect } from "react";
import { ToastPosition } from "react-hot-toast";

export function useToasterPosition(): ToastPosition {
    const [toasterPosition, setToasterPosition] = useState<ToastPosition>('bottom-right');

    useEffect(() => {
        function handleResize() {
            if (window.innerWidth < 768) {
                setToasterPosition('bottom-center');
            } else {
                setToasterPosition('bottom-center');
            }
        }
        handleResize();
        window.addEventListener('resize', handleResize);
        return () => window.removeEventListener('resize', handleResize);
    }, []);

    return toasterPosition;
}