var sumRootToLeaf = function(root) {
    let todosLosCaminos = [];

    // Definimos la función de exploración dentro para acceder a 'todosLosCaminos'
    function exploracion(nodo, acumulacion) {
        if (!nodo) return;

        // 1. Sumamos el valor actual al string (JS lo convierte a string automáticamente)
        acumulacion += nodo.val;

        // 2. ¿Es una hoja? (No tiene hijos)
        if (!nodo.left && !nodo.right) {
            todosLosCaminos.push(acumulacion);
            return;
        }

        // 3. Si no es hoja, seguimos explorando ambos lados
        exploracion(nodo.left, acumulacion);
        exploracion(nodo.right, acumulacion);
    }

    // Iniciamos la recursión con un string vacío
    exploracion(root, "");

    // 4. Convertimos cada binario a decimal y sumamos
    // Usamos parseInt(string, 2) que es el estándar en JS para base 2
    let sumaTotal = 0;
    for (let binario of todosLosCaminos) {
        sumaTotal += parseInt(binario, 2);
    }

    return sumaTotal;
};