/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/main/resources/templates/**/*.{html,thymeleaf}"],
  theme: {
    extend: {
      colors: {
        brand: {
          DEFAULT: '#9DE13D', // This is the default shade
        },
        brandhover: {
          DEFAULT: '#7BB12F',
        },
        brandbuttontext: {
          DEFAULT: '#3E5918',
        }
      },
    },
  },
  plugins: [],
}

