// Common JavaScript utilities

/**
 * Get the value of a cookie by its name.
 * @param {string} name - The name of the cookie.
 * @returns {string|null} - The value of the cookie, or null if not found.
 */
function getCookie(name) {
    const value = `; ${document.cookie}`;
    const parts = value.split(`; ${name}=`);
    if (parts.length === 2) return parts.pop().split(';').shift();
    return null;
}

// Export the function to make it accessible globally
window.getCookie = getCookie;
