export function formatDate(fecha: string | undefined): string {
    if (!fecha) return "";
    const date = new Date(fecha);
    const opciones: Intl.DateTimeFormatOptions = { year: 'numeric', month: 'long', day: 'numeric', hour: 'numeric', minute: 'numeric' };
    return date.toLocaleDateString('es-ES', opciones);
}