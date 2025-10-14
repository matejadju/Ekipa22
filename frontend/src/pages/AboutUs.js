export default function AboutUs() {
  return (
    <div className="relative min-h-screen flex items-center justify-center bg-gray-900 text-white overflow-hidden">

      <div className="absolute inset-0 bg-black opacity-60"></div>

      <div className="relative z-10 max-w-3xl px-6 py-12 text-center">
        <h2 className="text-5xl font-extrabold mb-6 text-blue-400 drop-shadow-md">
          Maribor ponoči
        </h2>

        <p className="text-lg leading-relaxed text-gray-200 mb-8">
          Naša platforma združuje vse dogodke, klube in kulturne prireditve v mestu Maribor.
          Omogočamo obiskovalcem enostaven pregled dogajanja, organizatorjem pa promocijo
          svojih prireditev.  
          Aplikacija spodbuja lokalno skupnost in krepi nočno življenje v mestu.
        </p>

        <p className="text-gray-400 text-sm mt-10">
          Ekipa <span className="font-semibold text-white">Maribor ponoči</span> ©{" "}
          {new Date().getFullYear()}
        </p>
      </div>
    </div>
  );
}
