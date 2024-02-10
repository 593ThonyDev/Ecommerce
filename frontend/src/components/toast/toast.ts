import { useState, useEffect } from "react";
import { ToastPosition } from "react-hot-toast";

export function useToasterPosition(): ToastPosition {
    const [toasterPosition, setToasterPosition] = useState<ToastPosition>('bottom-right');

    useEffect(() => {
        function handleResize() {
            // Detectar el tamaño de la ventana y establecer la posición del Toaster
            if (window.innerWidth < 768) {
                setToasterPosition('bottom-center');
            } else {
                setToasterPosition('bottom-right');
            }
        }

        // Llamar a la función handleResize al cargar y al redimensionar la ventana
        handleResize();
        window.addEventListener('resize', handleResize);
        return () => window.removeEventListener('resize', handleResize);
    }, []);

    return toasterPosition;
}